# escape=`

FROM postgres:11
LABEL author="ana"

ENV POSTGRES_PASSWORD aaa
ENV POSTGRES_DB sampledb

COPY dbscriptsOrder/ /docker-entrypoint-initdb.d/


#docker image build -t postgresbasic .