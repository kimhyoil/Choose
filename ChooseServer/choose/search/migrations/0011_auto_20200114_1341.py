# Generated by Django 3.0.2 on 2020-01-14 13:41

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('search', '0010_auto_20200114_0822'),
    ]

    operations = [
        migrations.AlterField(
            model_name='item',
            name='category',
            field=models.CharField(choices=[('생일', '생일'), ('효도', '효도'), ('출산, 돌', '출산, 돌'), ('명절', '명절'), ('입사', '입사'), ('퇴직', '퇴직'), ('입대', '입대'), ('전역', '전역'), ('연인', '연인'), ('결혼', '결혼'), ('졸업', '졸업'), ('집들이', '집들이')], max_length=30),
        ),
    ]