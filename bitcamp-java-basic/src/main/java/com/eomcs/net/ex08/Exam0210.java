package com.eomcs.net.ex08;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Exam0210 {

	public static void main(String[] args) throws Exception {

		URL url = new URL("http://itempage3.auction.co.kr/DetailView.aspx?itemno=C204190906");

		URLConnection con = url.openConnection();

		con.connect();

		System.out.printf("Connect-Type: %s\n", con.getContentType());
		System.out.printf("Connect-Length: %s\n", con.getContentLength());
		System.out.printf("Connect-Encoding: %s\n", con.getContentEncoding());

		System.out.printf("Content-Type: %s\n", con.getHeaderField("Content-Type"));
		System.out.printf("Server: %s\n", con.getHeaderField("Server"));
		System.out.println();

		InputStream in = con.getInputStream();

		BufferedReader in2 = new BufferedReader(new InputStreamReader(in));

		while (true) {
			String str = in2.readLine();
			if (str == null) 
				break;

			System.out.println(str);
		}

		in2.close();
		in.close();
	}

}
