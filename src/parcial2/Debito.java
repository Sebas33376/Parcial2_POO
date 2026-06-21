package parcial2;

import java.time.LocalDate;

public class Debito extends Tarjeta {

	public Debito(String titular, String numTarjeta, String codSeguridad, boolean estaActiva, LocalDate fechaImpresion,
			LocalDate fechaVencimiento) {

		super(titular, numTarjeta, codSeguridad, fechaImpresion, fechaVencimiento);

	}

	@Override
	public void Pagar(double monto, Cuenta cuenta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Transferir(double monto, Cuenta cuenta) {
		// TODO Auto-generated method stub

	}

}
