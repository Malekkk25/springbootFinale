package com.malek.vols.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import com.malek.vols.entities.Image;
public interface ImageRepository extends JpaRepository<Image , Long> {
}
