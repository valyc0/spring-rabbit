#!/usr/bin/env bash
# uso: ./send.sh [testo] [numero]
curl -X POST -H 'Content-Type: application/json' \
  -d "{\"text\":\"${1:-ciao rabbit}\",\"number\":${2:-1}}" localhost:8080/messages
echo
