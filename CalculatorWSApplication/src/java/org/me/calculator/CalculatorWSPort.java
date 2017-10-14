/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.calculator;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Estudiantes
 */
@Path("calculatorwsport")
public class CalculatorWSPort {

    private org.me.calculator_client.CalculatorWS port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CalculatorWSPort
     */
    public CalculatorWSPort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method add
     * @param i resource URI parameter
     * @param j resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("add/")
    public String getAdd(@QueryParam("i")
            @DefaultValue("0") int i, @QueryParam("j")
            @DefaultValue("0") int j) {
        try {
            // Call Web Service Operation
            if (port != null) {
                int result = port.add(i, j);
                return new java.lang.Integer(result).toString();
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private org.me.calculator_client.CalculatorWS getPort() {
        try {
            // Call Web Service Operation
            org.me.calculator_client.CalculatorWS_Service service = new org.me.calculator_client.CalculatorWS_Service();
            org.me.calculator_client.CalculatorWS p = service.getCalculatorWSPort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
