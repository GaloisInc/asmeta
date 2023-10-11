FROM amazoncorretto:17

ADD NuSMV-2.6.0-linux64.tar.gz /opt
ENV PATH "${PATH}:/opt/NuSMV-2.6.0-Linux/bin"
COPY dist /opt/asm-dist

WORKDIR /opt/asm-dist