# Cinema App

### Endpoints

| Endpoint                 | Params                                                                                     | Method | Returns                                          |
|--------------------------|--------------------------------------------------------------------------------------------|--------|--------------------------------------------------|
| /user/register           | username, password, email, firstName, lastName, address, city, province, country, postcode | POST   | User Added                                       |
| /user                    | id                                                                                         | GET    | User                                             |
| /user/login              | username, password                                                                         | GET    | User                                             |
| /user/payment/add        | payment_type, card_number, card_name, (Date) expiry_date, cvv, user_id                     | POST   | Payment Added                                    |
| /user/payment            | user_id                                                                                    | GET    | Users Payment                                    |
| /user/tickets            | user_id                                                                                    | GET    | List of users Tickets                            |
| /cinema/add              | name, company_name, address, city, province, country, postcode, (int) screens              | POST   | Cinema Added                                     |
| /cinema/screening/add    | (double) price, (LocalDateTime) screening_date, cinema_id, (int) movie_id                  | POST   | Screening Added                                  |
| /cinema/seat/add         | (int) screen_number, (char) row, (int) seat_number, cinema_id                              | POST   | Seat Added                                       |
| /cinema/ticket/add       | screening_id, seat_id, user_id                                                             | POST   | Ticket Added                                     |
| /cinema/screening/list   | (int) movie_id                                                                             | GET    | List of cinemas showing the movie                |
| /cinema/screening        | screening_id                                                                               | GET    | Screening                                        |
| /cinema/screening/movie  | cinema_id, (int) movie_id                                                                  | GET    | List of screenings for a movie and cinema        |
| /cinema/seat             | seat_id                                                                                    | GET    | Seat                                             |
| /cinema/ticket           | ticket_id                                                                                  | GET    | Ticket                                           |
| /movie/search            | search                                                                                     | GET    | List of BaseMovie's that titles match the search |
| /movie                   | movie_id                                                                                   | GET    | Movie                                            |
| /movie/trending/day      |                                                                                            | GET    | List of trending movies of the day               |
| /movie/trending/week     |                                                                                            | GET    | List of trending movies of the week              |
