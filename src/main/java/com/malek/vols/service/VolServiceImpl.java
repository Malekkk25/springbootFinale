package com.malek.vols.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malek.vols.entities.Aeroport;
import com.malek.vols.entities.Vol;
import com.malek.vols.entities.Image;
import com.malek.vols.repos.ImageRepository;
import com.malek.vols.repos.VolRepository;

@Service
public class VolServiceImpl implements VolService {
	
	@Autowired
	VolRepository volRepository;
	
	@Autowired
	ImageRepository imageRepository;
	
	@Override
	public Vol saveVol(Vol v) {
		// TODO Auto-generated method stub
		return volRepository.save(v);
	}

	/*@Override
	public Vol updateVol(Vol v) {
		// TODO Auto-generated method stub
		return volRepository.save(v);
	}*/
	@Override
	public Vol updateVol(Vol v) {
	//Long oldProdImageId = 
	//this.getVol(v.getIdVol()).getImage().getIdImage();
	/*Long newVolImageId = v.getImage().getIdImage();*/
	Vol vUpdated = volRepository.save(v);
	//if (oldProdImageId != newVolImageId) //si l'image a été modifiée
	//imageRepository.deleteById(oldProdImageId);
	return vUpdated;
	}


	@Override
	public void deleteVol(Vol v) {
		// TODO Auto-generated method stub
		 volRepository.delete(v);
		
	}

	/*@Override
	public void deleteVolById(Long id) {
		// TODO Auto-generated method stub
		 volRepository.deleteById(id);
	}**/
	@Override
	public void deleteVolById(Long id) {
	 Vol p = getVol(id);
	 //suuprimer l'image avant de supprimer le produit
	try {
	Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
	} catch (IOException e) {
	e.printStackTrace();
	} 
	volRepository.deleteById(id);
	}

	@Override
	public Vol getVol(Long id) {
		// TODO Auto-generated method stub
		 return volRepository.findById(id).get();
	}

	@Override
	public List<Vol> getAllVols() {
		// TODO Auto-generated method stub
		return volRepository.findAll();
	}

	@Override
	public List<Vol> findByNumVol(String num) {
		// TODO Auto-generated method stub
		return volRepository.findByNumVol(num);
	}

	@Override
	public List<Vol> findByNumVolContains(String num) {
		// TODO Auto-generated method stub
		return volRepository.findByNumVolContains(num);
	}

	@Override
	public List<Vol> findByDestAgen(String destination, String agence) {
		// TODO Auto-generated method stub
		return volRepository.findByNomDes(agence, destination);
	}

	@Override
	public List<Vol> findByAeroport(Aeroport aeroport) {
		// TODO Auto-generated method stub
		return volRepository.findByAeroport(aeroport);
	}

	@Override
	public List<Vol> findByAeroportIdAir(Long id) {
		// TODO Auto-generated method stub
		return volRepository.findByAeroportIdAir(id);
	}

	@Override
	public List<Vol> findByOrderByDestinationAsc() {
		// TODO Auto-generated method stub
		return volRepository.findByOrderByDestinationAsc();
	}

	@Override
	public List<Vol> trierVolDestAgen() {
		// TODO Auto-generated method stub
		return volRepository.trierVolDestAgen();
	}
	
	@Override
	public List<Vol> findByDestVolContains(String destination) {
		// TODO Auto-generated method stub
		return volRepository.findByDestVolContains(destination);
	}
	
}
