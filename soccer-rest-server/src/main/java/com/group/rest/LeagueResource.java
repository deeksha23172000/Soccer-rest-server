package com.group.rest;

import com.group.entity.League;
import com.group.service.LeagueService;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/leagues")
public class LeagueResource {
    @EJB
    private LeagueService leagueService;

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service is working!").build();
    }

    //Add team to the league
    @POST
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public Response createTeam(League league) {
        leagueService.addToList(league);
        return Response.status(Response.Status.CREATED).entity(league).build();
    }

}
