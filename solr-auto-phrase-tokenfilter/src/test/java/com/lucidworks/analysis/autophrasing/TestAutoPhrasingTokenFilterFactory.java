package com.lucidworks.analysis.autophrasing;

import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.BaseTokenStreamFactoryTestCase;
import org.apache.lucene.analysis.util.ClasspathResourceLoader;
import org.apache.lucene.analysis.util.ResourceLoader;

public class TestAutoPhrasingTokenFilterFactory extends BaseTokenStreamFactoryTestCase {

	public void testAutoPhrasingTokenFilterFactory() throws Exception {
		Reader reader = new StringReader("new york");
		TokenStream stream = whitespaceMockTokenizer(reader);
		
		Map<String, String> args = new HashMap<String, String>();
		args.put("phrases", "dictionary.txt");
		args.put("ignoreCase", "true");
		args.put("includeTokens", "true");  
		args.put("replaceWhitespaceWith", "true");  
		AutoPhrasingTokenFilterFactory f = new AutoPhrasingTokenFilterFactory(args);
		ResourceLoader l = new ClasspathResourceLoader();
		f.inform(l);
		stream = f.create(stream);
		assertTrue(stream instanceof AutoPhrasingTokenFilter);
	}

}
