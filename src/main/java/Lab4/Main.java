package Lab4;

import org.dizitart.no2.Cursor;
import org.dizitart.no2.Document;
import static org.dizitart.no2.Document.createDocument;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteCollection;
import org.dizitart.no2.filters.Filters;

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
        CreateAndInsertDoc(collection, 1, "Rose Diaz", 100000);
        CreateAndInsertDoc(collection, 2, "Mateo Lopez", 50000);
        CreateAndInsertDoc(collection, 3, "John Smith", 75000);
        
        
        //Retrieve all data
        Cursor results = collection.find();
        for (Document doc : results) {
            System.out.println(doc.toString());;
        }
        
        //Retrieve all results with salary above 70,000
        Cursor results2= collection.find(Filters.eq("salary" , 70000));
        for (Document currDoc : results2){
            System.out.println(currDoc.toString());;
        }

        //Close the database when you are done
        db.close();
    }

    public static void CreateAndInsertDoc(NitriteCollection collection, int id, String name, double salary) {
        Document doc = createDocument("id", 1)
                .put("name", name)
                .put("salary", salary);
        // insert a document into the collection
        collection.insert(doc);
    }
}
