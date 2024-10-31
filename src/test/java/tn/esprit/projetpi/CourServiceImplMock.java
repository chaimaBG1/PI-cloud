package tn.esprit.projetpi.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.projetpi.Entities.Cours;
import tn.esprit.projetpi.Entities.User;
import tn.esprit.projetpi.Repository.CoursRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CoursServiceTest {

    @InjectMocks
    private CoursService coursService;

    @Mock
    private CoursRepo coursRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddCours() {
        Cours cours = new Cours();
        when(coursRepo.save(any(Cours.class))).thenReturn(cours);

        Cours savedCours = coursService.addCours(cours);
        
        assertNotNull(savedCours);
        verify(coursRepo, times(1)).save(cours);
    }

    @Test
    void testUpdateCours() {
        Cours cours = new Cours();
        when(coursRepo.save(any(Cours.class))).thenReturn(cours);

        Cours updatedCours = coursService.updateCours(cours);

        assertNotNull(updatedCours);
        verify(coursRepo, times(1)).save(cours);
    }

    @Test
    void testGetAll() {
        List<Cours> coursList = new ArrayList<>();
        when(coursRepo.findAll()).thenReturn(coursList);

        List<Cours> result = coursService.getAll();

        assertEquals(coursList, result);
        verify(coursRepo, times(1)).findAll();
    }

    @Test
    void testGetById() {
        Long id = 1L;
        Cours cours = new Cours();
        when(coursRepo.findById(id)).thenReturn(Optional.of(cours));

        Cours result = coursService.getById(id);

        assertEquals(cours, result);
        verify(coursRepo, times(1)).findById(id);
    }

    @Test
    void testDeleteCours() {
        Long id = 1L;

        doNothing().when(coursRepo).deleteById(id);
        coursService.deleteCours(id);

        verify(coursRepo, times(1)).deleteById(id);
    }

    @Test
    void testAddCoursToUser() {
        Cours cours = new Cours();
        User user = new User();
        when(coursRepo.save(any(Cours.class))).thenReturn(cours);

        Cours result = coursService.AddCoursToUser(cours, user);

        assertEquals(cours, result);
        assertEquals(user, cours.getTuteur());
        verify(coursRepo, times(1)).save(cours);
    }
}
