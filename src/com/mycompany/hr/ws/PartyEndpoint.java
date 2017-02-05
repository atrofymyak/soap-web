package com.mycompany.hr.ws;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.xpath.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mycompany.hr.service.StubPartyResourceService;

@Endpoint                                                                                
public class PartyEndpoint {

  private static final String NAMESPACE_URI = "http://mycompany.com/hr/schemas";

  private XPath partyRequest;
  
  private XPath party;

  private XPath dateOfBirth;
  
  private XPath nameFirst;
  
  private XPath nameLast;

  private XPath nameExpression;

  private StubPartyResourceService humanResourceService;

  @Autowired
  public PartyEndpoint(StubPartyResourceService humanResourceService)                      
      throws JDOMException {
    this.humanResourceService = humanResourceService;

    Namespace namespace = Namespace.getNamespace("hr", NAMESPACE_URI);

    partyRequest = XPath.newInstance("//hr:PartyRequest");
    partyRequest.addNamespace(namespace);

    party = XPath.newInstance("//hr:Party");
    party.addNamespace(namespace);
    
    dateOfBirth = XPath.newInstance("//hr:dateOfBirth");
    dateOfBirth.addNamespace(namespace);
    
    nameFirst = XPath.newInstance("//hr:nameFirst");
    nameFirst.addNamespace(namespace);
    
    nameLast = XPath.newInstance("//hr:nameLast");
    nameLast.addNamespace(namespace);
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "PartyRequest")     
  @ResponsePayload
  public void handlePartyRequest(@RequestPayload Element partyRequest)               
      throws Exception {
    System.out.println("dsadas");
  }

}