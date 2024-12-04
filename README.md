# Prompt

## Models
- Please help me the models of Car, ParkingLot, and Ticket.
  Ticket and Car have a many-to-one relationship with ParkingLot. 
  A Car can be parked in a ParkingLot and a ParkingLot can have many Cars.
  A Ticket is created when a Car is parked in a ParkingLot. A Ticket has a reference to the Car and the ParkingLot.
  A Car has a license plate. A ParkingLot has a name and a map that map a ticket to a car.