# ADR 0002: Secret Management with Gitleaks

## Status
Accepted

## Context
The application handles sensitive data. We need to prevent accidental leakage of secrets in version control.

## Decision
Use Gitleaks to automatically scan commits and pull requests. Store secrets only in GitHub Actions secrets or environment variables.

## Consequences
- Pros: Prevents secret leaks, integrates with CI
- Cons: Adds build step, requires monitoring and occasional updates
