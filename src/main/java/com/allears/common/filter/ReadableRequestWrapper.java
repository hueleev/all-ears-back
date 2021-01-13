package com.allears.common.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

public class ReadableRequestWrapper extends HttpServletRequestWrapper {

    private static Logger logger = LoggerFactory.getLogger(ReadableRequestWrapper.class);

    final private String payload;

    public ReadableRequestWrapper(HttpServletRequest request) {
        super(request);

        // read the original payload into the xmlPayload variable
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            // read the payload into the StringBuilder
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[8192];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                // make an empty string since there is no payload
                stringBuilder.append("");
            }
        }
        catch (IOException ex) {
            logger.error("Error reading the request payload", ex);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException iox) {
                    // ignore
                }
            }
        }
        payload = stringBuilder.toString();
    }

    public String getPayload() {
        return payload;
    }

    @Override
    public ServletInputStream getInputStream ()
            throws IOException {

        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(payload.getBytes());
        ServletInputStream inputStream = new ServletInputStream() {
            public int read ()
                    throws IOException {
                return byteArrayInputStream.read();
            }

            @Override
            public boolean isFinished() {
                return byteArrayInputStream.available() == 0;
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
                throw new RuntimeException("Not implemented");
            }
        };
        return inputStream;
    }

}
