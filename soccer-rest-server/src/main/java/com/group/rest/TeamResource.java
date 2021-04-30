package com.group.rest;

import com.group.entity.Player;
import com.group.entity.PlayerUpdateDto;
import com.group.entity.Team;
import com.group.entity.TeamUpdateDto;
import com.group.service.PlayerService;
import com.group.service.TeamService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/teams")
public class TeamResource {
    @EJB
    private TeamService teamService;

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service is working!").build();
    }

    //Update Team name
    @PUT
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public Response updatePlayer(TeamUpdateDto updateDto) {
        if (updateDto.getId() == null || updateDto.getId() == 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\n" +
                            "\t\"ERROR\": \"Please provide correct id!\"\n" +
                            "}").build();
        }
        Team teamToUpdate = teamService.getById(updateDto.getId());
        if (teamToUpdate == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\n" +
                            "\t\"ERROR\": \"No such Team Member!\"\n" +
                            "}").build();
        }
        return Response.ok().entity(teamService.updateTeam(updateDto, teamToUpdate)).build();
    }

    //Add Player to the team
    @POST
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public Response createPlayerTeam(Team team) {
        teamService.addToList(team);
        return Response.status(Response.Status.CREATED).entity(team).build();
    }

}
