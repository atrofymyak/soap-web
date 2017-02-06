package com.mycompany.hr.ws;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.filter.Filters;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import com.mycompany.hr.service.StubPartyResourceService;

@Endpoint                                                                                
public class PartyEndpoint {

  private static final String NAMESPACE_URI = "http://mycompany.com/hr/schemas";

  private XPathExpression<Element> partyRequest;
  
  private XPathExpression<Element> party;

  private XPathExpression<Element> dateOfBirth;
  
  private XPathExpression<Element> nameFirst;
  
  private XPathExpression<Element> nameLast;

  private XPathExpression<Element> nameExpression;

  private StubPartyResourceService humanResourceService;

  @Autowired
  public PartyEndpoint(StubPartyResourceService humanResourceService)                      
      throws JDOMException {
    this.humanResourceService = humanResourceService;
    XPathFactory xpathFactory = XPathFactory.instance();

    Namespace namespace = Namespace.getNamespace("hr", NAMESPACE_URI);

    partyRequest = xpathFactory.compile("//hr:PartyRequest", Filters.element(), null, namespace);
   

    party = xpathFactory.compile("//hr:Party", Filters.element(), null, namespace);
   
    
    dateOfBirth = xpathFactory.compile("//hr:dateOfBirth", Filters.element(), null, namespace);
  
    
    nameFirst = xpathFactory.compile("//hr:nameFirst", Filters.element(), null, namespace);   
    
    nameLast = xpathFactory.compile("//hr:nameLast", Filters.element(), null, namespace);    
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "PartyRequest")     
//  @ResponsePayload
  public void handlePartyRequest(@RequestPayload Element partyRequest)               
      throws Exception {
    System.out.println("dsadas");
  }

}