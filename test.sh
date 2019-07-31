#!/bin/bash
set -B                  # enable brace expansion
for i in {1..100}; do
  curl -s -k 'GET' 'http://localhost:8080/api/v2/sessions'
done
