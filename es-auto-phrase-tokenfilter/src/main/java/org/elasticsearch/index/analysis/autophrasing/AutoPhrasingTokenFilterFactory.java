package org.elasticsearch.index.analysis.autophrasing;

import java.util.List;

import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;
import org.elasticsearch.index.analysis.Analysis;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.lucidworks.analysis.autophrasing.AutoPhrasingTokenFilter;

public class AutoPhrasingTokenFilterFactory extends AbstractTokenFilterFactory {

	private CharArraySet phraseSets;
	private final String phraseSetFiles;
	private final boolean ignoreCase;
	private final boolean emitSingleTokens;

	private String replaceWhitespaceWith = null;

	//private static final Logger Log = LoggerFactory.getLogger( AutoPhrasingTokenFilter.class );

	public AutoPhrasingTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
		super(indexSettings, name, settings);

		phraseSetFiles= settings.get( "phrases_path" );
		this.ignoreCase = settings.getAsBoolean("ignoreCase", false);
		this.emitSingleTokens = settings.getAsBoolean("includeTokens", false );
		String replaceWhitespaceArg = settings.get( "replaceWhitespaceWith" );
		if (replaceWhitespaceArg != null) {
			replaceWhitespaceWith = replaceWhitespaceArg;
		}

		if (phraseSetFiles != null) {
			List<String> pathLoadedPhrases = Analysis.getWordList(env, settings, "phrases");
			if (pathLoadedPhrases != null) {
				phraseSets = new CharArraySet(pathLoadedPhrases, ignoreCase);
			//} else {
			//	Log.debug("AutoPhrasingTokenFilterFactory - no phrases phrases loaded");			
			}
		//} else {
		//	Log.debug("AutoPhrasingTokenFilterFactory - no phrases file specified");
		}
	}

	@Override
	public TokenStream create(TokenStream tokenStream) {

		AutoPhrasingTokenFilter autoPhraseFilter = new AutoPhrasingTokenFilter( tokenStream, phraseSets, emitSingleTokens );
		if (replaceWhitespaceWith != null) {
			autoPhraseFilter.setReplaceWhitespaceWith( new Character( replaceWhitespaceWith.charAt( 0 )) );
		}
		return autoPhraseFilter;
	}
}