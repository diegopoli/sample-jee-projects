package com.dpoli.store.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dpoli.store.dao.ProjectDAO;
import com.dpoli.store.model.Project;
import com.thoughtworks.xstream.XStream;

@Path("project")
public class ProjectResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String search() {
		Project dao = new ProjectDAO().search(1l);
		return dao.toXML();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String searchJson() {
		Project dao = new ProjectDAO().search(1l);
		return dao.toJson();
	}

	@POST
	@Produces(MediaType.APPLICATION_XML)
	public String add(String contant) {
		Project project = (Project) new XStream().fromXML(contant);
		new ProjectDAO().add(project);
		return "<status>success</status>";
	}
}
