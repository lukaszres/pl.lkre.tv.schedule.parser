package pl.lkre.tv.teleman.utils;

import pl.lkre.tv.schedule.model.Seance;

import java.util.Calendar;
import java.util.List;

public class DateChanger {

    public List<Seance> proceed(List<Seance> seances) {
        boolean isNextDay = false;
        for (int i = 1; i < seances.size(); i++) {
            Seance seance = seances.get(i);
            if (!isNextDay && seances.get(i - 1).getDate().after(seance.getDate())) {
                isNextDay = true;
            }
            if (isNextDay) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(seance.getDate());
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                seance.setDate(calendar.getTime());
            }
        }
        return seances;
    }
}
