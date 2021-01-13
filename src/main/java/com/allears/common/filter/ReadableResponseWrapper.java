package com.allears.common.filter;

import org.apache.commons.io.output.TeeOutputStream;
import org.springframework.mock.web.DelegatingServletOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class ReadableResponseWrapper extends HttpServletResponseWrapper {

    private ByteArrayOutputStream outputStream;
    private PrintStream printStream;

    public ReadableResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    public ReadableResponseWrapper(HttpServletResponse response, ByteArrayOutputStream outputStream) {
        super(response);
        this.outputStream = outputStream;
        printStream = new PrintStream(outputStream);
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return new DelegatingServletOutputStream(new TeeOutputStream(super.getOutputStream(), printStream));
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(new DelegatingServletOutputStream(new TeeOutputStream(super.getOutputStream(), printStream)));
    }

    public String getPayload() {
        return outputStream.toString();
    }

}