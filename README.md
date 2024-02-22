# Cinema App

### Endpoints

| Endpoint                | Params                                                                                     | Method | Returns                                          |
|-------------------------|--------------------------------------------------------------------------------------------|--------|--------------------------------------------------|
| /cinema                 | cinema_id                                                                                  | GET    | Cinema                                           |
| /cinema/add             | name, company_name, address, city, province, country, postcode, (int) screens              | POST   | Cinema Added                                     |
| /cinema/movie           | (int) movie_id                                                                             | GET    | List of cinemas showing the movie                |
| /cinema/screening       | screening_id                                                                               | GET    | Screening                                        |
| /cinema/screening/add   | (double) price, (LocalDateTime) screening_date, cinema_id, (int) movie_id                  | POST   | Screening Added                                  |
| /cinema/screening/movie | cinema_id, (int) movie_id                                                                  | GET    | List of screenings for a movie and cinema        |
| /cinema/seat            | seat_id                                                                                    | GET    | Seat                                             |
| /cinema/seat/add        | (int) screen_number, (char) row, (int) seat_number, cinema_id                              | POST   | Seat Added                                       |
| /cinema/ticket          | ticket_id                                                                                  | GET    | Ticket                                           |
| /cinema/ticket/add      | screening_id, seat_id, user_id                                                             | POST   | Ticket Added                                     |
| /movie                  | movie_id                                                                                   | GET    | Movie                                            |
| /movie/cast             | movie_id                                                                                   | GET    | List of cast members for movie                   |
| /movie/release          | movie_id                                                                                   | GET    | List of release dates for movie                  |
| /movie/reviews          | movie_id                                                                                   | GET    | List of reviews for movie                        |
| /movie/search           | search                                                                                     | GET    | List of BaseMovie's that titles match the search |
| /movie/trending/day     |                                                                                            | GET    | List of trending movies of the day               |
| /movie/trending/week    |                                                                                            | GET    | List of trending movies of the week              |
| /user                   | user_id                                                                                    | GET    | User                                             |
| /user/login             | username, password                                                                         | GET    | User                                             |
| /user/payment           | user_id                                                                                    | GET    | Users Payment                                    |
| /user/payment/add       | payment_type, card_number, card_name, (Date) expiry_date, cvv, user_id                     | POST   | Payment Added                                    |
| /user/register          | username, password, email, firstName, lastName, address, city, province, country, postcode | POST   | User Added                                       |
| /user/tickets           | user_id                                                                                    | GET    | List of users Tickets                            |

