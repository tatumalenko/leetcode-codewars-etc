module.exports = function peopleStillOnBus(busStops) {
  let rem = 0;

  busStops.forEach(busStop => {
    rem += busStop[0];
    rem -= busStop[1];
  });

  return rem;
  //  return busStops.reduce((rem, [on, off]) => rem + on - off, 0);
};
