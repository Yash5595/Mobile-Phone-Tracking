# Mobile-Phone-Tracking

We will design a data structure that will help
us solve a simplified version of the mobile phone tracking problem, i.e., the
fundamental problem of cellular networks: When a phone is called, find where
it is located so that a connection may be established.

Each level i area exchange is served by a
level i+1 area exchange which serves a number of level i area exchanges, e.g.,
the Hauz Khas level 1 area exchange and the Malviya level 1 area exchange
may be both served by a South-Central Delhi level 2 area exchange. A base
station can be considered to be a level 0 area exchange in this hierarchical
structure. Given a level i exchange f , we say that the level i + 1 exchange
that serves it is the parent of f , and denote this parent(f ).

Making a phone call. When a phone call is made from phone p 1 registered
with base station b 1 to a phone p 2 , the first thing that the base station b 1
has to do is to find the base station with which p 2 is registered. For this
purpose there is an elaborate technology framework that has been developed
over time.For now, we will assume that b 1 sends a query to a central server C which maintains a data
structure that can answer the query and return the name of the base station,
let’s call it b 2 , with which p 2 is registered. C will also send some routing
information to b 1 so that b 1 can initiate a call with b 2 and, through the base
stations p 1 and p 2 can talk. It is the data structure at C that we will be
implementing in this assignment.

• addExchange a b - This should create a new Exchange b, and add it to
the child list of Exchange a. If node a has n children, b should be its
(n + 1) th child. If there is no Exchange with identifier a, then throw an
Exception.

• switchOnMobile a b - This should switch ON the mobile phone a at
Exchange b. If the mobile did not exist earlier, create a new mobile
phone with identifier a. If there is no Exchange with an identifier b,
throw an exception.

• queryFindPhone a - This should print the identifier of the exchange re-
turned by the findPhone(MobilePhone m) method. Here, m represents
the mobile phone whose identifier is a.

• queryLowestRouter a b - This should print the identifier of the ex-
change returned by the lowestRouter(Exchange e1, Exchange e2) method.
Here, e1 and e2 represent exchanges with identifier a and b respectively.

• queryFindCallPath a b - This should print the list returned by the
routeCall(MobilePhone m1, MobilePhone m2) method. Here, m1 and
m2 represent mobile phones with identifier a and b respectively. Suc-
cessive entries in the list should be separated by a comma.

• movePhone a b - This action should set the level 0 area exchange of the
mobile phone with identifier a to exchange with identifier b. Throw
exception if mobile a is not available, or exchange b does not exist.
