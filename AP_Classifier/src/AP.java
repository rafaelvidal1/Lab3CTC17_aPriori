import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AP {
	
	List<Filme> filmes = new ArrayList<Filme>();
	
	
	
	public void lerDoArquivo() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\rafae\\eclipse-workspace\\AP_Classifier\\src\\Filmes_Aval.txt"));
		String line;
		while((line = in.readLine()) != null){
		    //System.out.println(line);
		    this.filmes.add(new Filme(line.split(";")[0], 
		    		Integer.parseInt(line.split(";")[1])));
		    //System.out.println(line.split(";")[0]+ line.split(";")[3]+line.split(";")[1]+line.split(";")[2]+Integer.parseInt(line.split(";")[4]));
		}
		in.close();
	}
	
	public int aPriori(String nome) {
		for(Filme fm : filmes) {
			if(nome.equals(fm.nome))
				return fm.rate;
		}
		
		System.out.println("O filme não foi encontrado na banco de dados");
		return 3;
	}
	
	public static void main(String[] args) throws IOException {
		
		AP ap = new AP();
		ap.lerDoArquivo();
		Scanner scanner = new Scanner(System.in);  
		
		System.out.println("Digite o nome do filme: ");
		String nome = scanner.nextLine();  
		
		int rate = ap.aPriori(nome);
		System.out.printf("Rate do filme: %d",rate);
	}

}
