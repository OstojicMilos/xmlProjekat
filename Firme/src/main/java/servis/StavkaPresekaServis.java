package servis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StavkaPresekaRepozitorijum;

@Service
public class StavkaPresekaServis {

	@Autowired
	private StavkaPresekaRepozitorijum stavkaPresekaRepozitorijum;
	
}
