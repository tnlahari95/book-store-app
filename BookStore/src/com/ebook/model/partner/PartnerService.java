package com.ebook.model.service.Partner;

import java.util.Set;

import javax.jws.WebService;

import com.ebook.model.partner.Partner;
import com.ebook.model.service.Partner.representation.PartnerRepresentation;

@WebService
public interface PartnerService {
	   
	public Set<PartnerRepresentation> getPartners();
	public PartnerRepresentation getPartner(String Id);
	public void deletePartner(String id);
//	public Partner_Representation createPartner(Partner partner); FIX ME

   
    

}
