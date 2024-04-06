FROM maven



ADD https://dl.google.com/linux/direct/google-talkplugin_current_amd64.deb /src/google-talkplugin_current_amd64.deb

WORKDIR /Unifiedutility

COPY . .

RUN apt-get update \
    && apt-get -y install curl \
   # && apt-get -y install git \
    && apt-get -y install wget \
    #&& apt-get -y install net-tools \
    #&& apt-get -y install zip \
    && rm -rf /var/lib/apt/lists/*




# Install packages required by Chrome.
# If you want to install a newer Chrome version which requires a few more packages (but you don't know which), you will see the proper output.

RUN apt-get update && apt-get install -y lsb-release libgtk-3-0 libappindicator3-1 xdg-utils libxss1 libnss3 libnspr4 libasound2 libappindicator1 fonts-liberation libxss1 xdg-utils libasound2 libpango1.0-0 libpangoxft-1.0-0 libv4l-0 libv4lconvert0 libgdk-pixbuf2.0-0

RUN apt-get update && apt-get install -y \
apt-transport-https \
ca-certificates \
curl \
gnupg \
hicolor-icon-theme \
libcanberra-gtk* \
libgl1-mesa-dri \
libgl1-mesa-glx \
libpango1.0-0 \
libpulse0 \
libv4l-0 \
fonts-symbola \
--no-install-recommends \
&& curl -sSL https://dl.google.com/linux/linux_signing_key.pub | apt-key add - \
&& echo "deb [arch=amd64] https://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google.list \
&& apt-get update && apt-get install -y \
google-chrome-stable \
--no-install-recommends \
&& apt-get purge --auto-remove -y curl \
&& rm -rf /var/lib/apt/lists/*

RUN yes|apt --fix-broken install

RUN set -x \
&& apt-get update \
&& apt-get install -y --no-install-recommends \
ca-certificates \
curl \
unzip \
&& rm -rf /var/lib/apt/lists/* \
&& curl -sSL "https://dl.google.com/linux/direct/google-talkplugin_current_amd64.deb" -o /tmp/google-talkplugin-amd64.deb \
&& dpkg -i /tmp/google-talkplugin-amd64.deb \
&& mkdir \opt\selenium \
&& curl -sSL "https://storage.googleapis.com/chrome-for-testing-public/123.0.6312.58/linux64/chromedriver-linux64.zip" -o /tmp/chromedriver.zip \
&& unzip -o /tmp/chromedriver -d /Unifiedutility/chromedriver \
&& rm -rf /tmp/*.deb \
&& apt-get purge -y --auto-remove curl unzip

# Add chrome user
RUN groupadd -r chrome && useradd -r -g chrome -G audio,video chrome \
&& mkdir -p /home/chrome/Downloads && chown -R chrome:chrome /home/chrome







CMD ["/bin/bash"]