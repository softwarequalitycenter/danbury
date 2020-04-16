package com.wellsfargointerview.danbury.restservice;

import org.springframework.data.jpa.repository.JpaRepository;

interface TaskRepository extends JpaRepository<Task, Long> {

}
