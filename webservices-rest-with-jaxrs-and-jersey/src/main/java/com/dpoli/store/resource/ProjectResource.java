package com.dpoli.store.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dpoli.store.dao.ProjectDAO;
import com.dpoli.store.model.Project;
import com.thoughtworks.xstream.XStream;

@Path("project")
public class ProjectResource {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String search(@PathParam("id") long id) {
		Project project = new ProjectDAO().search(id);
		return project.toXML();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String searchJson() {
		Project project = new ProjectDAO().search(1l);
		return project.toJson();
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response add(String contant) {
		Project project = (Project) new XStream().fromXML(contant);
		new ProjectDAO().add(project);
		URI location = URI.create("/project/" + project.getId());
		return Response.created(location).build();
	}

	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") long id) {
		new ProjectDAO().remove(id);
		return Response.ok().build();
	}
}
