package com.dpoli.store.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dpoli.store.dao.ProjectDAO;
import com.dpoli.store.model.Project;

@Path("project")
public class ProjectResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String search() {
		Project dao = new ProjectDAO().search(1l);
		return dao.toXML();
	}
}
