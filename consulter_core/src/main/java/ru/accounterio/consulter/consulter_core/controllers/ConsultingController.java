package ru.accounterio.consulter.consulter_core.controllers;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Autowired;
import ru.accounterio.consulter.consulter_core.domains.CostSituation;
import ru.accounterio.consulter.consulter_core.domains.Situation;
import ru.accounterio.consulter.consulter_core.dto.Advice;
import ru.accounterio.consulter.consulter_core.dto.Consultation;
import ru.accounterio.consulter.consulter_core.exceptions.ConsultationException;
import ru.accounterio.consulter.consulter_core.exceptions.FormatException;
import ru.accounterio.consulter.consulter_core.interfaces.Consulter;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/api/consult")
public class ConsultingController {
    private final Consulter<CostSituation> consulter;

    @Autowired
    public ConsultingController(Consulter<CostSituation> consulter) {
        this.consulter = consulter;
    }

    @GET
    @Path("/consultation")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Consultation getConsultation(JAXBElement<Situation> situation, @Context HttpServletResponse response) {
        try {
            return consulter.consult(consulter.format(situation.getValue()));
        } catch (FormatException | ConsultationException fc) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return Consultation.exceptionBody(fc);
        }
    }

    @GET
    @Path("/advice")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Advice getAdvice(JAXBElement<Situation> situation, @Context HttpServletResponse response) {
        try {
            return consulter.advice(consulter.format(situation.getValue()));
        } catch (FormatException | ConsultationException fc) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return Advice.exceptionBody(fc);
        }
    }
}
