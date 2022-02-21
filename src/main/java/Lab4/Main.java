package Lab4;

import org.dizitart.no2.Document;
import static org.dizitart.no2.Document.createDocument;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteCollection;

/**
 *
 * @author Suleman Ali
 */
public class Main {

    public static void main(String[] args) {
        //    System.out.println("Hello World");

        //Create or Open the Database
        Nitrite db = Nitrite.builder().filePath("./company.db").openOrCreate();

        NitriteCollection collection = db.getCollection("employees");
        Document doc = createDocument("id", 1)
                .put("name" , "Rose Diaz ")
                .put("salary", 100000);
        // insert a document into the collection
        collection.insert(doc);

        //Close the database when you are done
        db.close();
    }
    public static Document CreateAndInsertDoc(){
        return null;
    }
}
