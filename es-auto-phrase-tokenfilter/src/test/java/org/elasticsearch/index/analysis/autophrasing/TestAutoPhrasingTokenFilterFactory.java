package org.elasticsearch.index.analysis.autophrasing;

import java.io.IOException;
//import java.io.Reader;
//import java.io.StringReader;
//
//import org.apache.lucene.analysis.TokenStream;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.index.Index;
import org.elasticsearch.test.ESTokenStreamTestCase;
//import org.elasticsearch.test.IndexSettingsModule;
//
//import com.lucidworks.analysis.autophrasing.AutoPhrasingTokenFilter;

public class TestAutoPhrasingTokenFilterFactory extends ESTokenStreamTestCase {

	public void testAutoPhrasingTokenFilterFactory() throws IOException {

//		//Reader reader = new StringReader("new york");
//		//TokenStream stream = whitespaceMockTokenizer(reader);
//		
//		final Index index = new Index("test", "_na_");
//        final String name = "ngr";
//        final Settings indexSettings = newAnalysisSettingsBuilder().build();
//        final Settings settings = newAnalysisSettingsBuilder().put("phrases", "dictionary.txt").put("ignoreCase", "true").put("includeTokens", "true").put("replaceWhitespaceWith", "true").build();
//        try {
//            new AutoPhrasingTokenFilterFactory(IndexSettingsModule.newIndexSettings(index, indexSettings), null, name, settings).create();
//            fail();
//        } catch (IllegalArgumentException expected) {
//            // OK
//        }
//        //stream = new AutoPhrasingTokenFilterFactory(IndexSettingsModule.newIndexSettings(index, indexSettings), null, name, settings).create(stream);
//    	//assertTrue(stream instanceof AutoPhrasingTokenFilter);
    }
	
}
