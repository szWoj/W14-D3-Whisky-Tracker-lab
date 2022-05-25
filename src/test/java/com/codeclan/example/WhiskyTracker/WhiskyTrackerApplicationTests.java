package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {
	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskiesForAParticularYear(){
		List<Whisky> whiskies = whiskyRepository.findByYear(1991);
		assertEquals(1,whiskies.size());
	}

	@Test
	public void canFindDistilleriesForAParticularRegion(){
		List<Distillery> distilleries = distilleryRepository.findByRegion("Lowland");
		assertEquals(2, distilleries.size());
	}

	@Test
	public void canFindWhiskyByAParticularDistilleryByAParticularAge(){
		List<Whisky> whiskies = whiskyRepository.findByAgeAndDistilleryName(12, "Rosebank");
		assertEquals("The Rosebank 12 - Flora and Fona", whiskies.get(0).getName());
 	}

	 @Test
	 public void canGetAllTheWhiskeyFromAParticularRegion(){
		List<Whisky> whiskies = whiskyRepository.findByDistilleryRegion("Lowland");
		assertEquals(1, whiskies.size());
	 }


	 @Test
	public void canFindDistilleriesWithWhiskeyOverAParticularAge(){
		List<Distillery> distilleries = distilleryRepository.findByWhiskiesAge(12);
		assertEquals(1, distilleries.size());
	 }
}
