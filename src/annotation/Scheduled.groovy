package annotation

enum DayOfWeek {mon,tue,wed,thu,fri,sat,sun}
@interface Scheduled {
    DayOfWeek dayOfWeek()
}