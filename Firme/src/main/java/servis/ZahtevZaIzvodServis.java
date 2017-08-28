package servis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ZahtevZaIzvodRepozitorijum;

@Service
public class ZahtevZaIzvodServis {

	@Autowired
	private ZahtevZaIzvodRepozitorijum zahtevZaIzvodRepozitorijum;
	

	
}
