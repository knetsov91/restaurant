# Security

## Overview

Spring Security 6 is used for authentication and authorization. Sessions are stateful — a session is created on login and destroyed on logout. Passwords are BCrypt-hashed. Access control works at two levels: URL patterns and method annotations (`@EnableMethodSecurity`).

## Authentication

Login is form-based (`POST /login`). The username field maps to the user's email. Passwords are stored as BCrypt hashes and compared by Spring Security during login.

- Success → redirect to `/panel`
- Failure → redirect to `/login?error`
- Logout → `POST /logout`, session invalidated, redirect to `/`

Spring Security loads users via `UserService`, which implements `UserDetailsService`. Lookup is by email; the result is wrapped in `AuthenticatedUser`.

## Authorization

### Roles

Four roles are defined on the `User` entity:

| Role | Notes |
|------|-------|
| `CUSTOMER` | Default role on registration |
| `EMPLOYEE` | Set when an employee record is created |
| `ADMIN` | Platform administration |
| `OWNER` | Restaurant owner |

Spring Security sees these as `ROLE_CUSTOMER`, `ROLE_EMPLOYEE`, etc.

### Public endpoints

- `GET /`, `/register`, `/login`
- `GET /restaurants/*/menus`
- `GET /menus/*`
- `GET /restaurants/*/reservations/new`
- `POST /reservations`
- Static resources (CSS, JS, images)

Everything else requires a valid session.

### Method-level security

Controllers and services use `@PreAuthorize` for role checks that go beyond URL matching.

## Registration

`POST /register` is public. The server checks for a duplicate email and matching password/confirmation before saving. Error messages are intentionally generic — no indication of whether the email exists. On success the user gets the `CUSTOMER` role and a `Customer` profile is created.
