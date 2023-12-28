
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import enums.SubscriptionType;

class MainTest {

    private Main mainService;
    private SubscriptionPlan basicPlan;
    private SubscriptionPlan premiumPlan;

    @BeforeEach // This method will be called before each test method
    void setUp() {
        mainService = new Main();
        basicPlan = new SubscriptionPlan(SubscriptionType.STANDARD_WITH_ADS);
    }

    @AfterEach // This method will be called after each test method
    void tearDown() {
        mainService = null;
        basicPlan = null;
    }

    @Test // This is a test case
    @DisplayName("Register new user with basic plan") 
    void testRegisterUser() {
        mainService.registerUser("john@example.com", "password123", basicPlan);
        assertNotNull(mainService.getUsers().get("john@example.com"));
    }

    @Test
    @DisplayName("Register user that already exists")
    void testRegisterUserThatExists() {
        mainService.registerUser("jane@example.com", "password123", basicPlan);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            mainService.registerUser("jane@example.com", "password123", basicPlan);
        });

        String expectedMessage = "User already exists";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Change existing user's subscription plan")
    void testChangeSubscriptionPlan() {
        mainService.registerUser("alice@example.com", "password123", basicPlan);
        mainService.changeSubscriptionPlan("alice@example.com", SubscriptionType.PREMIUM);
        assertEquals(SubscriptionType.PREMIUM, mainService.getUsers().get("alice@example.com").getPlan().getType());
    }

    @Test
    @DisplayName("Change subscription plan of non-existing user")
    void testChangeSubscriptionPlanNonExistingUser() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            mainService.changeSubscriptionPlan("nonexisting@example.com", SubscriptionType.PREMIUM);
        });

        String expectedMessage = "User does not exist";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Change existing user's email")
    void testChangeEmail() {
        mainService.registerUser("testuser1@test.com", "password123", basicPlan);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            mainService.changeEmail("jvnfdsljkn@vnxflkn.com", "nvdflgjnb@vlknxvbf.com");
        });

        String expectedMessage = "User does not exist";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

        mainService.changeEmail("testuser1@test.com", "updateduser@test.com");
        assertEquals("updateduser@test.com", mainService.getUsers().get("updateduser@test.com").getEmail());
    }

    @Test
    @DisplayName("Change existing user's password")
    void testChangePassword() {
        mainService.registerUser("testuser1@test.com", "password123", premiumPlan, "1234567890");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            mainService.changePassword("tser1@test.com", "pass3");
        });

        String expectedMessage = "User does not exist";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        
        mainService.changePassword("testuser1@test.com", "password123");
        assertEquals("password123", mainService.getUsers().get("testuser1@test.com").getPassword());
    }

    @Test
    @DisplayName("Change existing user's phone number")
    void testChangePhone() {
        mainService.registerUser("testuser1@test.com", "password123", premiumPlan, "1234567890");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            mainService.changePhone("", "1234567890");

        });

        String expectedMessage = "User does not exist";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

        mainService.changePhone("testuser1@test.com", "1234567890");

        assertEquals("1234567890", mainService.getUsers().get("testuser1@test.com").getPhone());
    }}



