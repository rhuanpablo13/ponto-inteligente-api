import com.kazale.pontointeligente.services.impl.LancamentoServiceImp;

public class Teste {

	public static void main(String[] args) {
		
		LancamentoServiceImp lanc = new LancamentoServiceImp();
		lanc.buscarPorId(new Long(2));
		
	}
}
