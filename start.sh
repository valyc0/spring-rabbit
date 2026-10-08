#!/usr/bin/env bash
cd "$(dirname "$0")"
docker compose up -d
mvn spring-boot:run
