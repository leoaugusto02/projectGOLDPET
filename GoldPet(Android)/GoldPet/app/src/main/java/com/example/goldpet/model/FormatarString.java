package com.example.goldpet.model;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class FormatarString {
    public String UTF8toISO(String str) {
        Charset utf8charset = Charset.forName("ISO-8859-1");
        Charset iso88591charset = Charset.forName("UTF-8");

        ByteBuffer inputBuffer = ByteBuffer.wrap(str.getBytes());

        // decode UTF-8
        CharBuffer data = utf8charset.decode(inputBuffer);

        // encode ISO-8559-1
        ByteBuffer outputBuffer = iso88591charset.encode(data);
        byte[] outputData = outputBuffer.array();
        return new String(outputData);
    }
}
