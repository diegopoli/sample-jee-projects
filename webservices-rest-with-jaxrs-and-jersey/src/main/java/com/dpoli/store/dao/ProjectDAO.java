package com.dpoli.store.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.dpoli.store.model.Project;

public class ProjectDAO {

	private static Map<Long, Project> database = new HashMap<>();
	private static AtomicLong counter = new AtomicLong(1);

	static {
		database.put(1l, new Project(1l, "Project 01", 2014));
		database.put(2l, new Project(2l, "Project 02", 2012));
	}

	public void add(Project project) {
		long id = counter.incrementAndGet();
		project.setId(id);
		database.put(id, project);
	}

	public Project search(Long id) {
		return database.get(id);
	}

	public Project remove(long id) {
		return database.remove(id);
	}
}
