import com.mongodb.*;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import ge.softgen.loanexpert.controller.ExceptionHandlingController;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by vano on 3/15/15.
 */
public class MongoDB {
	private static final String IP = "localhost";
	private static final int PORT = 27017;
	private static String dbName = "mydb";
	private static String collectionName = "testData";
	private static String COLL_TMP = "tmp";
	private static String COLL_FS = "fs";

	private static GridFS gridFS;
	private static DB db;
	public static void main(String args[]){
		try {
			MongoClient client = new MongoClient(IP, PORT);
			db = client.getDB(dbName);
			DBCollection collection = db.getCollection(collectionName);
			DBCursor cursor = collection.find();

			upload();

			while(cursor.hasNext()){
				System.out.println(cursor.next());
			}

		} catch (Exception e){
			e.printStackTrace();
		}
	}
	public static void upload() throws IOException {
		File file = new File("/home/vano/IdeaProjects/SpringContainer/src/test/resources/test.png");
		gridFS = new GridFS(db, COLL_TMP);
		GridFSInputFile inputFile = gridFS.createFile(file);

		inputFile.setContentType("image/png");
		inputFile.save();
	}
	public DBCursor getFiles() {
		DBCollection collection = db.getCollection(COLL_FS + ".files");
		return collection.find();
	}
}
