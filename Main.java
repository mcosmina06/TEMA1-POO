package tema1;
import java.io.*;

public class Main {
	/**
	 * in Main se face citirea din fisier linie cu linie si se realizeaza
	 * functiile ce au trebuit implementate
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 * @throws ArrayIndexOutOfBoundsException
	 * @throws IOException
	 */
	public static void main(String[] args) throws FileNotFoundException, ArrayIndexOutOfBoundsException, IOException {
	    /**
	     * in vectorul de tip Bilet se retin Pasagerii(familie/grup/persoana)
	     */
		Bilet [] B; 
		/**
		 * arborele maxHeap implementat prin vector
		 */
	    MaxHeap H = new MaxHeap();
	    /**
	     * vectorul auxiliar fololosit la realocarea arborelui
	     */
	    MaxHeap aux;
	    /**
	     * in vectorul P se va stoca un element din vectorul B ce se vrea a fi
	     * inserat in MaxHeap
	     */
	    Pasager [] P = new Pasager[1];
	    /**
	     * dim reprezinta dimensiunea actuala a vectorului B
	     */
	    int dim = 0;
	    int i;
	    /**
	     * variabila folosita pentru a se identifica daca exista deja sau nu familia/grupul
	     * dupa id
	     */
	    int ok = 0;
	    /**
	     * primul numarul citit din fisierul de intrare
	     */
	    int n = 0;

	    try
	      {
	      	File fileWriter = new File("queue.out");
			FileWriter output = new FileWriter(fileWriter, true);
	        
			FileReader fileReader = new FileReader("queue.in");
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        
	        /**
	         * string pentru stocarea fiecarei linii din fisier
	         */
	        String s;
	       
	        n = Integer.parseInt(bufferedReader.readLine());
	        
	        B = new Bilet[n];
	        
	         while ((s = bufferedReader.readLine()) != null)
	         {
	        	 String [] r = s.split("\\s");
	        	 
	        	 /**
	        	  * daca comada este "insert" se cauta in vectorul B dupa id Pasagerul ce se vrea a fi
	        	  * inserat
	        	  */
	        	 if(r[0].equals("insert")) {
	        		 for(i = 0; i < dim; i++) {
	        			 if(r[1].equals(B[i].get_id())) {
	        				 P[0] = B[i];
	        				 break;
	        			 }
	        		 }
	        		 
	        		 /**
	        		  * daca arborele este gol se apeleaza constructorul cu un parametru
	        		  * si se aloca arborele de dimensiune 1
	        		  */
	        		 if(H.get_ne() == 0) {
	        			 H = new MaxHeap(1);
	        		 }
	        		 
	        		 /**
	        		  * in caz contrar se realizeaza realocarea arborelui de dimensiunea curenta + 1
	        		  */
	        		 else {
	        			 aux = new MaxHeap(H.get_ne());
	        			 aux.set_ne(H.get_ne());
	        			 aux.set_okList(H.get_okList());
	        			 aux.set_ok(H.get_ok());
	        			 aux.v = H.v;
	        			 H = new MaxHeap(aux.get_ne() + 1);
	        			 H.set_ne(aux.get_ne());
	        			 H.set_okList(aux.get_okList());
	        			 H.set_ok(aux.get_ok());
	        			 for(i = 0; i < H.get_ne(); i++) {
	        				 H.v[i] = aux.v[i];
	        			 } 
	        		 }
	        		 
	        		 H.insert(P[0], P[0].getPriority());
	        	 }
	        	 
	        	 else if(r[0].equals("embark")) {
	        		 H.embark();
	        	 }
	        	 
	        	 /**
	        	  * daca se apeleaza functia de stergere se cauta pasagerul in vectorul de bilete
	        	  * si se apeleaza functia delete;
	        	  */
	        	 else if(r[0].equals("delete")) {
	        		 for(i = 0; i < dim; i++) {
	        			 if(r[1].equals(B[i].get_id())) {
	        				 P[0] = B[i];
	        			 }
	        		 }
	        		 H.delete(P[0]);
	        	 }
	        	 
	        	 else if(r[0].equals("list")) {
	        		 H.list();
	        	 }
	        	 /**
	        	  * in cazul in care linia nu reprezinta niciuna din comenzile de mai sus inseamna
	        	  * ca se citeste o linie ce contine informatii despre persoane ce trebuiesc adaugate in Pasager;
	        	  * in cazul in care id - ul de pe linia citita nu exista se aloca o noua pozitie din B si se creaza o 
	        	  * noua instanta de tip Pasager, iar daca nu se actualizeaza vectorii de informatii din Pasager a id -ului respectiv
	        	  */
	        	 else {
		        		 if(dim == 0) {
		        		 B[dim] = new Bilet(r[0]);
		        		 B[dim].addinfo(r[1], Integer.parseInt(r[2]), r[3], Boolean.parseBoolean(r[4]), Boolean.parseBoolean(r[5]));	   
		 				 B[dim].set_priority();
		        		 dim++;
		        	 }
		        	 
		        	 else {
		        		 ok = 0;
		        		 for(i = 0; i < dim; i++) {
		        			 if(r[0].equals(B[i].get_id())) {
		        				 B[i].addinfo(r[1], Integer.parseInt(r[2]), r[3], Boolean.parseBoolean(r[4]), Boolean.parseBoolean(r[5]));
		        				 ok = 1;
		        				 B[i].set_priority();
		        			 }
		        		 }
		        		 
		        		 if(ok == 0) {
			        		 B[dim] = new Bilet(r[0]);
			        		 B[dim].addinfo(r[1], Integer.parseInt(r[2]), r[3], Boolean.parseBoolean(r[4]), Boolean.parseBoolean(r[5]));
			        		 B[dim].set_priority();
			        		 dim++;	 
		        		 }
		        	 }
	        	 }
	         }

	         fileReader.close();
	         bufferedReader.close();
	      }
		
		
		catch (ArrayIndexOutOfBoundsException e) {
        }	     
		catch (Exception e){
	         System.out.println(e.toString());
	    }
	}
}
