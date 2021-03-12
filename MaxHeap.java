package tema1;
import java.io.*;


public class MaxHeap {

	/**
	 * numaruk efectiv de elemente din Heap
	 */
	private int ne; 
	/**
	 * vectorul de Pasageri prin care este reprezentat Heap - ul
	 */
	public	Pasager [] v;
	/**
	 * variabila folosita pentru scrierea corecta in fisier
	 */
	private int ok = 0;
	/**
	 * variabila folosita pentru scrierea corecta in fisier
	 */
	private int okList = 0;
	/**
	 * Constructor fara parametruu ce initializeaza campurile din Heap
	 */
	MaxHeap() {
		ne = 0;
		v = new Pasager[0];
		ok = 0;
		okList = 0;
	}
	
	/**
	 * Constructor cu un parametru ce initializeaza Heap - ul de dimensiune data
	 * 
	 * @param x reprezinta dimensiunea ce vrem sa fie alocata pentru heap
	 */
	MaxHeap(int x) {
		ne = 0;
		v = new Pasager[x];
		okList = 0;
		ok = 0;
	}
	
	/**
	 * metoda ce intoarce numerul de elemente din Heap
	 * 
	 * @return numarul de elemente din heap
	 */
	public int get_ne() {
		return this.ne;
	}

	/**
	 * @return contorul elementelor afisate de pe o linie
	 */
	public int get_ok() {
		return this.ok;
	}

	/**
	 * @returnvariabila contorul apelurilor functiei list
	 */
	public int get_okList() {
		return this.okList;
	}
	
	/**
	 * metode ce actualizeaza numarul de elemente din heap
	 * 
	 * @param x noul numarul al elementelor din heap 
	 */
	public void set_ne(int x) {
		this.ne = x;
	}

	/**
	 * @param x noua valoare a variabilei ok
	 */
	public void set_ok(int x) {
		this.ok = x;
	}

	/**
	 * @param x noua valoare a variabilei okList
	 */
	public void set_okList(int x) {
		this.okList = x;
	}
	
	/**
	 * metoda de comparatie a doua elemte
	 * 
	 * @param a primul element al comparatie
	 * @param b al doilea element al comparatiei
	 * @return
	 */
	private int Trel(int a, int b) {
		return (b - a);
	}
	
	/**
	 * metoda ce calculeaza si intoarce pozitia parintelui pozitiei 
	 * date ca parametru
	 * 
	 * @param fiu pozitia pentru care se doreste aflarea pozitiei parinte
	 * @return pozitia parintelui
	 */
	private int getParinte(int fiu) {
		return ((fiu - 1) / 2);
	}
	
	/**
	 * metoda ce calculeaza si intoarce pozitia fiului stang ala pozitiei 
	 * date ca parametru
	 * 
	 * @param parinte pozitia pentru care se doreste aflarea pozitiei fiului stang
	 * @return pozitia fiului stang
	 */
	private int getFiuStanga(int parinte) {
		return (2 * parinte + 1);
	}
	
	/**
	 * metoda ce calculeaza si intoarce pozitia fiului drept ala pozitiei 
	 * date ca parametru
	 * @param parinte pozitia pentru care se doreste aflarea pozitiei fiului drept
	 * @return pozitia fiului drept
	 */
	private int getFiuDreapta(int parinte) {
		return (2 * parinte + 2);
	}
	
	/**
	 * metoda de inserare in heap
	 * 
	 * @param x pasagerul de inserat
	 * @param priority prioritatea pasagerului de inserat
	 */
	public void insert(Pasager x, int priority)
	{
		int poz;
		Pasager aux;
		poz = ne;
		ne++;
		v[poz] = x;
		while(Trel(v[getParinte(poz)].getPriority(), v[poz].getPriority()) > 0)
		{
			aux = v[getParinte(poz)];
			v[getParinte(poz)] = v[poz];
			v[poz] = aux;
			poz = getParinte(poz);
		}	
	}
	
	/**
	 * metoda de extragere a varfului din Heap si intoarce Pasagerul extras
	 * 
	 * @return varful Max Heap - ului
	 */
	public Pasager embark() {
		int poz_root, s, d, next;
		Pasager ret;
		Pasager aux;
		ret = v[0];
		poz_root = 0;
		v[0] = v[ne - 1];
		ne--;
		while(getFiuStanga(poz_root) < ne)
		{
			s = getFiuStanga(poz_root);
			d = getFiuDreapta(poz_root);
			next = s;
			if(d != 0 && Trel(v[s].getPriority(), v[d].getPriority()) > 0)
				next = d;
			if(Trel(v[next].getPriority(), v[poz_root].getPriority()) >= 0)
				break;
			aux = v[poz_root];
			v[poz_root] = v[next];
			v[next] = aux;
			poz_root = next;
		}
		return ret;
	}
	
	/**
	 * functie ce verifica daca un nod al arborelui este frunza
	 * @param poz pozitia nodului pentru care se doreste verificarea
	 * @return true daca este frunza, false in caz contrar
	 */
	private boolean isLeaf(int poz) {
		if(poz >= (ne/2) && poz <= ne) {
			return true;
		}
		return false;
	} 
	
	/**
	 * functia este apelata dupa ce s - a produs stergerea unui pasager pentru refacerea heap - ului
	 * in functie de prioritatea pasagerilor, unde nu se respecta conditia de heap se face swap
	 * @param poz pozitia de pe care a fost scos elementul si inlocuit cu cel mai din dreapta nod
	 */
	public void reorganizare_heap(int poz) {
		Pasager aux;
		if(isLeaf(poz))
			return;
		if(v[poz].getPriority() < v[getFiuDreapta(poz)].getPriority() || v[poz].getPriority() < v[getFiuStanga(poz)].getPriority()) {
			if(v[getFiuStanga(poz)].getPriority() > v[getFiuDreapta(poz)].getPriority()) {
				aux = v[getFiuStanga(poz)];
				v[getFiuStanga(poz)] = v[poz];
				v[poz] = aux;	
				reorganizare_heap(getFiuStanga(poz));
			}
			else {
				aux = v[getFiuDreapta(poz)];
				v[getFiuDreapta(poz)] = v[poz];
				v[poz] = aux;
				reorganizare_heap(getFiuDreapta(poz));
			}
		}
	}	
	/**
	 * metoda cauta dupa id pasagerul in vectorul ce reprezinta heap - ul
	 * si retine pozitia acestuia
	 * @param P pasagerul ce se doreste a fi sters
	 */
	void delete(Pasager P) {
		int i, poz = 0;
		for(i = 0; i < ne; i++) {
			if(P.getID() == v[i].getID()) {
				poz = i;
				break;
			}
		}
		v[poz] = v[ne - 1];
		ne--;
		reorganizare_heap(poz);
	}
	
	/**
	 * metoda de parcurgere in preordine al arborelui si scriere in fisier
	 * 
	 * @param poz pozitia curenta in arbore
	 * @param output fisierul in care se scrie
	 * @throws IOException
	 */
	public void RSD(int poz,  FileWriter output) throws IOException {
		if(poz >= ne) {
			return;
		}
		
		/**
		 * daca este ultimul element de afisat nu se mai pune spatiu dupa
		 */
		if(ok == (ne - 1)) {
			output.write(v[poz].getID());
		}
		else {
			output.write(v[poz].getID()+ " ");
			ok++;
		}
		RSD(getFiuStanga(poz), output);
		RSD(getFiuDreapta(poz), output);
	}
	
	/**
	 * metoda ce implementeaza list - ul
	 * @throws IOException
	 */
	public void list() throws IOException {
		File fileWriter = new File("queue.out");
		FileWriter output = new FileWriter(fileWriter, true);
		
		/**
		 * daca nu este primul list sa se treaca pe urmatorul rand in fisier
		 */
		if(okList >= 1) {
			output.write("\r\n");
		}
		okList++;
		ok = 0;
		RSD(0, output);
		output.close();
	}

}
