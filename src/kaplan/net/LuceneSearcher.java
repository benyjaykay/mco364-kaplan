package kaplan.net;


import java.io.File;
import java.io.FileReader;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

public class LuceneSearcher {

	private Analyzer analyzer;
	private Directory indexDir;
	public static final String INDEX_DIRECTORY = "indexDirectory";
	public static void main(String[] args) throws IOException, ParseException {
		File indexDir = new File("indexDirectory");
		File dataDir = new File("tmp");
		Directory index = new RAMDirectory();
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);
		LuceneSearcher lucy = new LuceneSearcher();
		lucy.setAnalyzer(analyzer);
		lucy.createIndex(index,dataDir,lucy.getAnalyzer());
		
		lucy.setDirectory(index);
		lucy.searchIndex("Messi");
	}
	public Analyzer getAnalyzer(){
		return analyzer;
	}
	public void setAnalyzer(Analyzer analyzer){
		this.analyzer = new StandardAnalyzer(Version.LUCENE_40);
	}
	public Directory getDirectory(){
		return indexDir;
	}
	public void setDirectory(Directory directory){
		this.indexDir = directory;
	}
	@SuppressWarnings("deprecation")
	public void createIndex(File indexDir, File dataDir,Analyzer analyzer) throws IOException{
		
		  
		
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40,analyzer);
		IndexWriter indexWriter = new IndexWriter(FSDirectory.open(indexDir),config);
		
		File[] files = dataDir.listFiles();
		for (File file: files){
			Document document  = new Document();
			document.add(new TextField("path",file.getCanonicalPath(),Field.Store.YES));
			document.add(new Field("contents",new FileReader(file),new FieldType()));
			indexWriter.addDocument(document);
			
		}
		indexWriter.close();
	}
	public void searchIndex(String searchString) throws ParseException, IOException{
		System.out.println("Searchin for " + searchString + ".");
		IndexReader indexReader = DirectoryReader.open(getDirectory());
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		Query query = new QueryParser(Version.LUCENE_40,"content", analyzer).parse(searchString); 
		TopScoreDocCollector collector = TopScoreDocCollector.create(10, true);
		indexSearcher.search(query, collector);
		ScoreDoc[] hits = collector.topDocs().scoreDocs;
		System.out.println("Returned" + hits.length);
		for(int i = 0;i < hits.length;++i){
			int docId = hits[i].doc;
			Document d = indexSearcher.doc(docId);
			System.out.println((i + 1) + ". " + d.get("path") + "\t" + d.get("content"));
		}
		indexReader.close();
		
	}
}
