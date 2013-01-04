RandomSymlinker
===============

This allows you to easily symlink /dev/urandom to /dev/random to work around slow randomness. This will speed up your device quite a bit as Android will use /dev/random for it's randomness, /dev/random being slow this makes everything that kinda needs it slow. /dev/urandom being fast speeds it up quite a bit.
