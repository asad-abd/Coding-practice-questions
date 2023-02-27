class Solution {
    /*
        1 step/min (6 degrees) that min hand takes ~ 30 (degrees) / 

        ((hr % 12) * 30) + 30 * ((min * 6) / 360)

        12:30
        angle 1: ((hr % 12) * 30) + 30 * (180 / 360) -> 15

        3:30
        30 -> 15

    */
    // common sense - think normally
    public double angleClock(int hour, int minutes) {
        double angle_hr = (((double)hour % 12) * 30) + (30 * ((double)minutes * 6) / 360);

        double angle_min = (((double)minutes * 360) / 60);

        double diff = Math.abs(angle_hr - angle_min);
        return Math.min(diff, 360 - diff);
    }
}