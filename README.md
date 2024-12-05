# Prompt

## Models
- Please help me the models of Car, ParkingLot, and Ticket.  
  Ticket and Car have a many-to-one relationship with ParkingLot.  
  A Car can be parked in a ParkingLot and a ParkingLot can have many Cars.  
  A Ticket is created when a Car is parked in a ParkingLot. A Ticket has a reference to the Car and the ParkingLot.  
  A Car has a license plate. A ParkingLot has a name and a map that map a ticket to a car.

## Testing
- Please help me write a test for ParkingLotController. For now just write a test for GET /parkinglots  
  The test function name shoud be in the form of should_<expected result>_when_<action>_given_<given condition> Use `@SpringBootTest`, `@AutoConfigureJsonTesters`, `@AutoConfigureMockMvc` and `JacksonTester`.  
  Add a `@BeforeEach` for deleteAll the repository and add some dummy field.  
- Help me solve this error: "Cannot find a (Map) Key deserializer for type [simple type, class org.afs.pakinglot.model.Ticket]"
- Help me write a enum called ParkingStrategies that is return the three ParkingStrategy: Standard, Smart, and SuperSmart.   
  Write an GET API /parkingBoys that return this enum values.
  Write an POST API /parkingBoys/park that use ParkingBoy to park the car and save it in ticketRepository and carRepository.